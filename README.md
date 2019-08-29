# cfping

Minimalistic 70KB self-contained Java Ping App. Sometimes you need a minimal app that can be 
served over http on a cloud platform

### Deployment on Cloud Foundry

Change directory to where you have checked this project out. Deploy using `cf push`. There is already a manifest.yml
that uses the [SAP Java Build Pack](https://help.sap.com/viewer/65de2977205c403bbc107264b8eccf4b/Cloud/en-US/a3f90069d6cd41da82f34a6123d82ce6.html).

Access https://ping[.my.cf.domain.com] Example: https://ping.cfapps.sap.hana.ondemand.com