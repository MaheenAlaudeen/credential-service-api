[![License](https://img.shields.io/badge/License-EPL%201.0-red.svg)](https://opensource.org/licenses/EPL-1.0)
[![Build Status](https://travis-ci.org/dellemc-symphony/credential-service-api.svg?branch=master)](https://travis-ci.org/dellemc-symphony/credential-service-api)
[![Slack](http://community.codedellemc.com/badge.svg)](https://codecommunity.slack.com/messages/symphony)
[![Codecov](https://img.shields.io/codecov/c/github/dellemc-symphony/credential-service-api.svg)](https://codecov.io/gh/dellemc-symphony/credential-service-api)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.dell.cpsd/credential-service-api/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.dell.cpsd/credential-service-api)
[![Semver](http://img.shields.io/SemVer/2.0.0.png)](http://semver.org/spec/v2.0.0.html)

# credential-service-api
## Description

This is the Credential Service API  project description
## Documentation

This project holds JSON schema definition to communicate with Credentials Service. 

| SCHEMA      | TYPE    | DESCRIPTION  |
| ---------   | :------:| ------------:|
| PublicKeyRequest | REQUEST |This schema will be used to request for Credential Service public key |
| CredentialsWriteRequest | REQUEST | This schema will be used if a client wants to store credentials specific to just one single UUID(credential UUID) |
| CredentialsReadRequest | REQUEST | This schema will be used if a client wants to read credentials for a specific single UUID credential UUID |
| ComponentCredentialsWriteRequest | REQUEST | This Schema will be used if a client wants to store credentials specific to component-uuid/endpoint- uuids & Credential UUID |
| ComponentCredentialsReadRequest | REQUEST | This schema will be used if a client wants to read credentials based on component-uuid/endpoint-uuid & credential uuid | 
| PublicKeyResponse| RESPONSE |The schema represents the object structure of PublicKey Response from Credential service in Base 64 string format |
| CredentialsResponse | RESPONSE | This schema represents object structure for credentialsReadRequest response. Username/Password will be encrypted with public key string from CredentialsReadRequest |
| ComponentCredentialsResponse | RESPONSE |This schema represents object structure for ComponentCredentialsReadRequest response. Username/Password will be encrypted with public key string from ComponentCredentialsReadRequest |

## API Reference
## Prerequisites
Maven
Java 1.8
## Compilation: How to Compile
mvn clean compile
## Packaging: How to Package
mvn clean package
## Automated Testing
## How to Deploy and Run
## How to Contribute

Project Symphony is a collection of services and libraries housed at [GitHub][github].

Contribute code and make submissions at the relevant GitHub repository level. See [our documentation][contributing] for details on how to contribute.

## Community and Support

Reach out to us on the Slack [#symphony][slack] channel by requesting an invite at [{code}Community][codecommunity].

You can also join [Google Groups][googlegroups] and start a discussion.

[slack]: https://codecommunity.slack.com/messages/symphony

[googlegroups]: https://groups.google.com/forum/#!forum/dellemc-symphony

[codecommunity]: http://community.codedellemc.com/
[contributing]: http://dellemc-symphony.readthedocs.io/en/latest/contributingtosymphony.html
[github]: https://github.com/dellemc-symphony
[documentation]: https://dellemc-symphony.readthedocs.io/en/latest/

