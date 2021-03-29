## 安装systemctl服务
#sudo apt-get -y install --reinstall systemd
## 设置服务开机启动
#sudo systemctl enable ssh
#
#curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
#sudo mkdir -p /etc/docker
#sudo tee /etc/docker/daemon.json <<-'EOF'
#{
#  "registry-mirrors": ["https://dnt2rnqf.mirror.aliyuncs.com"]
#}
#EOF
#sudo systemctl daemon-reload
#sudo systemctl restart docker
#docker run --cidfile=/var/lib/vagrant/cids/1570360f1082c4a07a86d30265a35460145cb2e7 -d --name mongoDB --restart=always -p 27017:27017 mongo
