# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "archlinux/archlinux"
  config.ssh.username = "vagrant"
  config.vm.synced_folder ".", "/home/vagrant/multipods", create:true

  config.vm.provision :ansible do |ansible|
        ansible.playbook = "config/deploy/playbook.yml"
  end
end
