/var/lib/jenkins/aws_jenkins configure < /var/lib/jenkins/configFile.txt
publicIP=$(/var/lib/jenkins/aws_jenkins ec2 describe-instances --filters "Name=tag:Name,Values=elk_medium" --query 'Reservations[*].Instances[*].PublicIpAddress' --output text)

echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>
<project>
<node name=\"spectrum_ec2_aws\" description=\"Spectrum Website\" tags=\"\"
  hostname=\"$publicIP\" osArch=\"amd64\" osFamily=\"unix\"
  osName=\"Linux\" osVersion=\"4.15.0-1032-aws\"
  username=\"ubuntu\" ssh-authentication=\"privateKey\"
    ssh-key-storage-path=\"keys/ec2_medium\"
/>
</project>" > /home/charan/sem8/devops/master/jenkins_config/docker_elk_resources.xml

echo "Resource File Generated "