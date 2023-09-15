DESCRIPTION = "FTDI driver for using ftdi USB chips"
HOMEPAGE = "https://github.com/eblot/pyftdi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=58c1136e68ef55b83b66209b2a18daf7"


SRC_URI = "https://github.com/eblot/pyftdi/archive/v${PV}.tar.gz"
SRC_URI[sha256sum] = "3989782dbc806fa1c7b89ba8bdcc51c282663be0d59a3b6dc47738d9975c6e0a"

S = "${WORKDIR}/pyftdi-${PV}"

inherit setuptools3

DEPENDS += "python3-pyusb python3-pyserial"

RDEPENDS:${PN}+= "python3-pyusb python3-pyserial"

