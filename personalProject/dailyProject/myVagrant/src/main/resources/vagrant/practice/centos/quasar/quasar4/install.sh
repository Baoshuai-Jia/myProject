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
npm config set unsafe-perm true
# 安装quasar
npm install -g @quasar/cli
# 安装code-server
wget https://github.com/cdr/code-server/releases/download/3.4.1/code-server-3.4.1-linux-x86_64.tar.gz # 下载
tar -xvzf code-server-3.4.1-linux-x86_64.tar.gz # 解压
mv code-server-3.4.1-linux-x86_64 code-server #重命名
cd code-server
# 后台运行
screen -S vscode
export PASSWORD="yourpassword" && ./code-server --port 9999 --host 0.0.0.0

