# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "generic/ubuntu2004"
  config.ssh.username = "vagrant"
  config.vm.synced_folder ".", "/home/vagrant/multipods", create:true
  config.ssh.insert_key = false

  config.vm.provision :ansible do |ansible|
        ansible.playbook = "config/deploy/playbook.yml"
        ansible.verbose = "v"
        ansible.host_key_checking = false
  end

  config.vm.provider :virtualbox do |v| 
    # (default) memory: 512MB, cpus: 1
    v.memory = 6144
    v.cpus = 4
  end
end
