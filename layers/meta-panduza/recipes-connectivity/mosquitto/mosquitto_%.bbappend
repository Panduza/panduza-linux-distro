FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " file://mosquitto.conf"

do_install:append() {
    install -d ${D}${sysconfdir}/mosquitto/
    install -D -m 644 ${WORKDIR}/mosquitto.conf ${D}${sysconfdir}/mosquitto/mosquitto.conf
}
