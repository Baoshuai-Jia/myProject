# 安装wget
yum install -y wget
# 安装nodejs
cd /home/vagrant
wget https://nodejs.org/dist/v14.17.0/node-v14.17.0-linux-x64.tar.xz
xz -d node-v14.17.0-linux-x64.tar.xz
tar xvf node-v14.17.0-linux-x64.tar
echo 'export PATH=$PATH:/home/vagrant/node-v14.17.0-linux-x64/bin' >> /etc/profile
source /etc/profile
# 安装vue
npm install -g cnpm --registry=https://registry.npm.taobao.org
cnpm install -g vue-cli
sudo npm install -g @quasar/cli