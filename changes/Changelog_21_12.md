- Zuerst wurden yml. Dateien erstellt, mit denen der Cluster über 'kubectl' gesteurt wurde
- Erstellung eines Helm-Charts mittels 'helm create'
- Parametrisierung der yml-dateien
- Speicherung der Credentials als Secrets (Steht noch aus ) 
- Erstellung eines Datenbank-Reset-Jobs
- angepasste Ressourcen-Anforderungen für grey-instanz (Steht noch aus ) 

Controls:
- Geheimnisse werden als Secrets gespeichert
- Passwort und Nutzername in .pgpass-datei (Steht noch aus ) 

Für RQ relevant: 
- Blue, Green und temp in unterschiedlichen namespaces
