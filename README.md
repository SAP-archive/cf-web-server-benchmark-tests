![](https://img.shields.io/badge/STATUS-NOT%20CURRENTLY%20MAINTAINED-red.svg?longCache=true&style=flat)

# Important Notice
This public repository is read-only and no longer maintained. For the latest sample code repositories, visit the [SAP Samples](https://github.com/SAP-samples) organization.

# Cloud Foundry Web Server Brenchmark Test

[![REUSE status](https://api.reuse.software/badge/github.com/SAP-samples/cf-web-server-benchmark-tests)](https://api.reuse.software/info/github.com/SAP-samples/cf-web-server-benchmark-tests)

# Description
>Each programming language has been designed for a specific use-case and performs well / resource efficient for this use-case. But this doesn’t mean that a programming language is suited for all .

This repository contains three almost identical simple web server applications (written in Java, Golang and Node.js respectively) to demonstrate their distinct runtime properties hands-on. We have measured the footprints of those applications, which ran on SAP BTP, Cloud Foundry environment, to validate the  hypothesis.

Check out this [blog post](https://blogs.sap.com/2018/07/27/comparing-different-application-runtimes-on-sap-cloud-platform-cloud-foundry/) for more details and the results of the experiment.
# Requirements
* [Get a Free Account on SAP BTP Trial](https://www.sap.com/developer/tutorials/hcp-create-trial-account.html) or use the [Free Tier](https://blogs.sap.com/2021/07/01/exploring-btps-new-free-tier-plans/)
* [Install the Cloud Foundry Command Line Interface (CLI)](https://developers.sap.com/tutorials/cp-cf-download-cli.html)

# Download and Installation
Please clone this repository and use `cf push` to deploy all three applications to you Cloud Foundry space.

## Deploy the Golang app
1. Browse to the golang project folder
```bash
cd golang
```
2. Deploy the app
```bash
cf push
```

## Deploy the Java app
>Note: Please make sure to re-build the .jar archive if you want to modify the codebase of the java application

1. Browse to the java project folder
```bash
cd ../java
```
2. Deploy the app
```bash
cf push
```

## Deploy the Node.js app
1. Browse to the node project folder
```bash
cd ../node
```
2. Deploy the app
```bash
cf push
```

# Known Issues
The purpose of these apps is to demonstrate the memory consumption and CPU utilization of the respective Cloud Foundry runtimes given a very simple task. This experiment should not suggest that any programming language is superior to the other.

# How to obtain support
Please open issues here on Github if you find errors or bugs in the implementation. You can use the comments section of the [blog post](https://blogs.sap.com/2018/07/27/comparing-different-application-runtimes-on-sap-cloud-platform-cloud-foundry/) for general remarks.

