# panduza-linux-distro
Linux distribution ready to deploy on some popular boards

To build the image run the command :

```bash
./kas-container build [your-machine]-base.yml
```

### Wifi Connection :

There are two ways to connect to Wifi :

> Before building and flashing on SD Card

Create the configuration file by running the following command on your desktop. This will prompt you for the passphrase for your WiFi. 

```bash
wpa_passphrase 'YOUR_SSID' >  ../sources/meta-panduza/recipes-connectivity/wpa-supplicant/files/wpa_supplicant-nl80211-wlan0.conf
```
> Or after flashing (on your board)

You can run the following commmands on your board :

```bash
wpa_passphrase [ ssid ] [ passphrase ]
```
```bash
reboot
```