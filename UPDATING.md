## Updating AWS CloudFormation

The Gradle Hero S3 bucket and policies are created with *[cloud.yml](cloud.yml)*. This also includes OpenID Connect setup between GitHub & AWS.

Apply changes manually with this command:

```bash
aws cloudformation update-stack --stack-name gradle-hero --template-body file://./cloud.yml --capabilities CAPABILITY_IAM
aws cloudformation wait stack-update-complete --stack-name gradle-hero
```