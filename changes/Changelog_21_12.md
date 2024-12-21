- Zuerst wurden yml. Dateien erstellt, mit denen der Cluster über 'kubectl' gesteurt wurde
- Erstellung eines Helm-Charts mittels 'helm create'
- Parametrisierung der yml-dateien
- Speicherung der Credentials als Secrets (Steht noch aus ) 
- Erstellung eines jobs (kubernetes docs)
  - multiple commands https://www.baeldung.com/linux/kubernetes-pass-many-commands
  - 

Controls:
- Geheimnisse werden als Secrets gespeichert
- Passwort und Nutzername in .pgpass-datei

Für RQ relevant: 
- Blue, Green und temp in unterschiedlichen namespaces
