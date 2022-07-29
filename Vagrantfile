# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "archlinux/archlinux"
  config.vm.synced_folder ".", "/var/multipods", create:true
  config.ssh.username = "vagrant"

  config.vm.provision :ansible do |ansible|
        ansible.playbook = "config/deploy/playbook.yml"
  end
end
