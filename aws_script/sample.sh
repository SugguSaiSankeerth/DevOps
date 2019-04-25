pip install awscli --upgrade

echo -e "\nConfiguring aws tool\n"  
aws configure < /home/charan/sem8/devops/master/jenkins_config/configFile.txt

echo -e "\n\nGenerating Resource XML File\n"
publicIP=$(aws ec2 describe-instances --filters "Name=tag:Name,Values=docker_elk" --query 'Reservations[*].Instances[*].PublicIpAddress' --output text)

echo -e "<?xml version=\"1.0\" encoding=\"UTF-8\"?>
<project>
<node name=\"spectrum_ec2_aws\" description=\"Spectrum Website\" tags=\"\"
  hostname=\"$publicIP\" osArch=\"amd64\" osFamily=\"unix\"
  osName=\"Linux\" osVersion=\"4.15.0-1032-aws\"
  username=\"ubuntu\" ssh-authentication=\"privateKey\"
    ssh-key-storage-path=\"keys/ec2-key\"
/>
</project>" > /home/charan/sem8/devops/master/jenkins_config/docker_elk_resources.xml

echo "Done."