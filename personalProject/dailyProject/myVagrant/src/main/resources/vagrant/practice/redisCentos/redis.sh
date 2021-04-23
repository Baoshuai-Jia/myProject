sudo mv /vagrant_data/redis-6.2.2.tar.gz /opt/
sudo tar -zxvf /opt/redis-6.2.2.tar.gz
sudo cd /home/vagrant/redis-6.2.2
sudo yum install gcc-c++ -y
sudo yum -y install gcc automake autoconf libtool make
sudo make
sudo make install

