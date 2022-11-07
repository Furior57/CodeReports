 ������ ��������� ������������� ��� �������� ������� � Data-matrix ������ ��� ��������� ���������� ������������
���������� � ������� "������� ����". ���������� - ��� ��������� ���-������ ������� �� ���������� ��������� �����
��� �������� ���������� � ��������. ����� ����� ���� ������, � ������� ���������� ������������ � json �������, �����
������������ ��� � ��������� ������ � ���� ������. � ���������� ������, ��������� API ������������ ���� ����������,
����� �������� ������ ���������� � ���������� �� �� ������ ����������.

                                            ���������� �� ��������� � ���������

 ��������� ������������� � ������������� �� Ubuntu 22.04.1 LTS jammy, ��� ������� ��-��������� ������� sudo.


1. ��������� ������� ���������.

 ������������� ����� ��� ������������� ������� � ��������� ����������:
    apt-get install chrony
    systemctl enable chrony

 ��������� ����������� ����� � �����������:
    ufw allow 445
    ufw allow 137
    ufw allow 138
    ufw allow 139

 ������������� Samba � ��������� ����������:
    apt-get install samba
    systemctl enable smbd

 ��������� ������ CIFS ��� ����������� ������� ��������� Windows:
    apt-get install cifs-utils

 �������� ��������� ��� ����� ������������:
    mkdir /mnt/pet
    mkdir /mnt/polyak
    mkdir /mnt/ispanec
    mkdir /mnt/tuba
    mkdir /mnt/banka
 ������ ��������� ����� �� ������ ������������, �� ��������� ������� � ��������:
    chown shad /mnt/share - ������ share ������ �������� �������� ��� ����� ������������

 �������� ����� ��� �������� ������ � ������ ����������� � ������� ���������:
    vim ~/.smbcredentials
 ���������� �����:
    username=���-������������
    password=������
 ����������� ���� ������� � �����:
    chmod 600 ~/.smbcredentials
 ��-��������� ���� ��������� � �������� ������������ ������� ��� ������, ������ ���� ����� ��������:
    realpath ~/.smbcredentials
 ��������� ��������������� ������������ ������� ���������:
 ��������� ���� fstab:
    vim /etc/fstab
 ������ ��������� ������:
    //192.168.1.60/vmkzfolder1$  /mnt/pet cifs    credentials=/root/.smbcredentials,uid=1000,iocharset=utf8,nofail,_netdev   0   0
    //192.168.1.60/vmkzfolder2$  /mnt/polyak cifs    credentials=/root/.smbcredentials,uid=1000,iocharset=utf8,nofail,_netdev   0   0
    //192.168.1.60/vmkzfolder3$  /mnt/ispanec cifs    credentials=/root/.smbcredentials,uid=1000,iocharset=utf8,nofail,_netdev   0   0
    //192.168.1.60/vmkzfolder4$  /mnt/tuba cifs    credentials=/root/.smbcredentials,uid=1000,iocharset=utf8,nofail,_netdev   0   0
    //192.168.1.60/vmkzfolder5$  /mnt/banka cifs    credentials=/root/.smbcredentials,uid=1000,iocharset=utf8,nofail,_netdev   0   0



2. ���������� � ��������� ���������.


