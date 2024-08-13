package accounts.grpc.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accounts.app.account.Entity.Account;
import accounts.app.user.entities.User;
import accounts.app.user.repository.UserRepository;

import accounts.grpc.user.protobuff.UserGrpc;
import accounts.grpc.user.protobuff.UserOuterClass.AccountReadDto;
import accounts.grpc.user.protobuff.UserOuterClass.Empty;
import accounts.grpc.user.protobuff.UserOuterClass.UserData;
import accounts.grpc.user.protobuff.UserOuterClass.UserList;
import accounts.grpc.user.protobuff.UserOuterClass.UserReadDto;
import accounts.grpc.util.ResponseBuilder;
import io.grpc.stub.StreamObserver;

@Service
public class UserService extends UserGrpc.UserImplBase{

    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public void getUsers(Empty request,
    StreamObserver<UserList> responseObserver) {
        List<User> users = userRepository.findAll();

        List<UserReadDto> usersToBeShown = new ArrayList<>();

        ResponseBuilder<UserList> responseBuilder = new ResponseBuilder<UserList>(responseObserver);
 
        for(User x : users){

            List<Account> userAccounts = x.getAccounts();
            List<AccountReadDto> accountsToBeShown = new ArrayList<AccountReadDto>();

            for(Account y : userAccounts){
                accountsToBeShown.add(
                    AccountReadDto.newBuilder()
                                  .setAccountId(y.getAccount_id())
                                  .setAccountStatus(y.getAccount_status())
                                  .setAccountAmount(y.getAccount_amount())
                                  .setCurrency(y.getCurrency())
                                  .build()
                );  
            }

            usersToBeShown.add(
                UserReadDto.newBuilder()
                           .setId(x.getId())
                           .setUserData(UserData.newBuilder()
                                        .setFamilyName(x.getFamily_name())
                                        .setSurname(x.getSurname())
                                        .setAddress(x.getAddress())
                                        .setPhoneNumber(x.getPhone_number())
                                        .build())
                           .addAllAccountData(accountsToBeShown)
                           .build()
            );

        }
    
        UserList userList = UserList.newBuilder().addAllUserReadData(usersToBeShown).build();

        responseBuilder.onNext(userList).build().onCompleted();
    }

    
}
