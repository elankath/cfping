# pingjava

Minimalistic 70KB self-contained Java Ping App with root http endpoint that prints host and environment info in plain text.
Sometimes you need a minimal, test app that can be served over http on a cloud platform and you don't want to build one.

## Build

You need to have [Apache Maven](https://maven.apache.org) installed.  
* `git clone https://github.com/elankath/pingjava`
* `cd pingjava`
* `mvn -nsu install`
* uberjar is produced at `target/ping.jar`. (~70KB size)

### Deployment on Cloud Foundry

Just do a `cf push -f cf.yml`

*NOTE*:
* Endpoint: https://ping[.my.cf.domain.com] Example: https://ping.cfapps.sap.hana.ondemand.com
* Manifest uses the [SAP Java Build Pack](https://help.sap.com/viewer/65de2977205c403bbc107264b8eccf4b/Cloud/en-US/a3f90069d6cd41da82f34a6123d82ce6.html), 
but you change this to the normal Java Build Pack.

### Deployment on Kubernetes

TODO: Describe me!

