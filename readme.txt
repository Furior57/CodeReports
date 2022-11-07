 Данная программа предназначена для парсинга отчетов с Data-matrix кодами для продукции подлежащей обязательной
маркировке в системе "Честный знак". Структурно - это небольшой веб-сервер который по расписанию запускает метод
для проверки директорий с отчетами. Найдя новый файл отчета, в котором информация представлена в json формате, метод
обрабатывает его и сохраняет данные в базу данных. В дальнейшем клиент, используя API выставленный этой программой,
может получить данную информацию и обработать ее по своему усмотрению.

                                            ИНСТРУКЦИЯ ПО УСТАНОВКЕ И НАСТРОЙКЕ

 Программа настраивалась и тестировалась на Ubuntu 22.04.1 LTS jammy, все команды по-умолчанию требуют sudo.


1. Настройка сетевых каталогов.

 Устанавливаем демон для синхронизации времени и разрешаем автозапуск:
    apt-get install chrony
    systemctl enable chrony

 Разрешаем необходимые порты в брандмауэре:
    ufw allow 445
    ufw allow 137
    ufw allow 138
    ufw allow 139

 Устанавливаем Samba и разрешаем автозапуск:
    apt-get install samba
    systemctl enable smbd

 Установка пакета CIFS для подключения сетевых каталогов Windows:
    apt-get install cifs-utils

 Создание каталогов для точек монтирования:
    mkdir /mnt/pet
    mkdir /mnt/polyak
    mkdir /mnt/ispanec
    mkdir /mnt/tuba
    mkdir /mnt/banka
 Меняем владельца папки на нашего пользователя, во избежание проблем с доступом:
    chown shad /mnt/share - вместо share ввести название каталога для точки монтирования

 Создание файла для хранения логина и пароля подключения к сетевым каталогам:
    vim ~/.smbcredentials
 Содержание файла:
    username=ИМЯ-ПОЛЬЗОВАТЕЛЯ
    password=ПАРОЛЬ
 Ограничение прав доступа к файлу:
    chmod 600 ~/.smbcredentials
 По-умолчанию файл создается в каталоге пользователя который его создал, узнать путь можно командой:
    realpath ~/.smbcredentials
 Настройка автоматического монтирования сетевых каталогов:
 Открываем файл fstab:
    vim /etc/fstab
 Внутрь добавляем строки:
    //192.168.1.60/vmkzfolder1$  /mnt/pet cifs    credentials=/root/.smbcredentials,uid=1000,iocharset=utf8,nofail,_netdev   0   0
    //192.168.1.60/vmkzfolder2$  /mnt/polyak cifs    credentials=/root/.smbcredentials,uid=1000,iocharset=utf8,nofail,_netdev   0   0
    //192.168.1.60/vmkzfolder3$  /mnt/ispanec cifs    credentials=/root/.smbcredentials,uid=1000,iocharset=utf8,nofail,_netdev   0   0
    //192.168.1.60/vmkzfolder4$  /mnt/tuba cifs    credentials=/root/.smbcredentials,uid=1000,iocharset=utf8,nofail,_netdev   0   0
    //192.168.1.60/vmkzfolder5$  /mnt/banka cifs    credentials=/root/.smbcredentials,uid=1000,iocharset=utf8,nofail,_netdev   0   0



2. Подготовка к установке программы.


