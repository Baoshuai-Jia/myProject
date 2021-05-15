yum install wget -y
yum install socat logrotate -y
cd /home/vagrant
wget https://github.com/rabbitmq/erlang-rpm/releases/download/v23.3.3/erlang-23.3.3-1.el7.x86_64.rpm
rpm -Uvh erlang-23.3.3-1.el7.x86_64.rpm
wget https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.8.16/rabbitmq-server-3.8.16-1.el7.noarch.rpm
rpm -Uvh rabbitmq-server-3.8.16-1.el7.noarch.rpm
yum install erlang -y
yum install rabbitmq-server -y
sudo systemctl start rabbitmq-server
##开启web管理页面
sudo rabbitmq-plugins enable rabbitmq_management
# 开启web远程连接
sudo touch /etc/rabbitmq/rabbitmq.config
sudo echo "[{rabbit, [{loopback_users, []}]}]." >> /etc/rabbitmq/rabbitmq.config
sudo systemctl restart rabbitmq-server
