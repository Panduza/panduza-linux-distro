SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Panduza Recipe created by bitbake-layers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV_PANDUZA_PY = "ad0040e8f1321b3b29959a6c8f1a89e14fe1e05e"
SRCREV_PANDUZA_INSTALLER = "0c80bcb2bbb701195488cd4d5c33909be0654abf"

# don't put : "protocol=https"
# client and admin tools installation : git://github.com/Panduza/panduza-py.git;branch=main;egg=panduza;subdirectory=client;destsuffix=git/src 

SRC_URI = "\
    git://github.com/Panduza/panduza-py.git;branch=main;destsuffix=git/panduza-py;rev=${SRCREV_PANDUZA_PY} \
    git://github.com/Panduza/panduza-installer.git;branch=main;destsuffix=git/panduza-installer;rev=${SRCREV_PANDUZA_INSTALLER} \
    file://tree.json \
    file://BSDL \
    file://11-ftdi.rules \
" 

S = "${WORKDIR}/git"

HOME = "/home/root"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Panduza recipe created by bitbake-layers   *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build

RDEPENDS:panduza = "perl bash"



do_install() {
    install -d ${D}${bindir}
    install -d ${D}${HOME}
    install -d ${D}${sysconfdir}/panduza
    install -d ${D}${sysconfdir}/panduza/BSDL
    install -d ${D}${sysconfdir}/udev/rules.d
    

    #install -m 0755 ${S}/* ${D}${bindir}
    #install -D -m 600 ${S}/* ${D}${bindir}
    #install -D -m 600 ${S}/* ${D}${HOME}

    cp -r ${S}/* ${D}${bindir}
    cp -r ${S}/* ${D}${HOME}
   
    
    install -D -m 600 ${WORKDIR}/tree.json ${D}${sysconfdir}/panduza/
    install -D -m 600 ${WORKDIR}/BSDL/* ${D}${sysconfdir}/panduza/BSDL
    install -D -m 600 ${WORKDIR}/11-ftdi.rules ${D}${sysconfdir}/udev/rules.d/

}

FILES:${PN} +=  " ${HOME}/* ${bindir}/* ${sysconfdir}/* "
