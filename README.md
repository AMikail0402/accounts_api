Wichtige Dateien: 

////// Schema-transfer //////////

Genereller Ablauf:
1. Löschung von Test-Tabellen
2. Schema-Dump von Prod wird in temporären Container gespeichert
3. Einspielen des Schema-Dumps in Test-DB

/deployment/db --> Alle Daten bezüglich des Schema-Transfers

             /users --> Alle SQL-Nutzeraccounts

             /sql_code --> Code der für Löschung von Test-Tabellen genutzt wird

             /files --> pgpassfile und sql-code base64-codiert in kubernetes-secrets

             tranfer-job.yaml --> Kubernetes-Job

/security/roles/transfer-role --> RBAC-Rolle für Transfer

////////////////////////////////

/scripts für den deployment prozess:

                  Zuerst Ausführung von deploy.sh um graue Instanz bereitzustellen 

                  --> falls neue instanz akzeptiert wird deploy_new_version.sh: Führt dazu, dass Test-Instanz gelöscht wird, und Neue Version in der Umgebung bereitsgestellt wird, die nicht von den Kunden genutzt wird.

                  --> falls nicht /steps/delete_grey.sh ausführen um Test-Instanz zu löschen, und zurück zum Ausgangszustand zu kommen

/security für Härtungsmaßnahmen

            /roles --> rbac rollen

            /cis-hardening -- > Konfiguration der kubernetes komponenten

            /secrets --> Speicherung von sensiblen Dateien

            /deployment für Anwendungsbereitstellungen

            /api_secure --> Bereitstellung von Api-Pods, die mit Podsecurity-Standards konform sind

            /networking --> Anpassung der Netzwerkkonfiguration
