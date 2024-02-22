SUMMARY = "Teh service will install the libraries and run the Panduza platform"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Specify the source files to fetch
SRC_URI = "file://run-platform.service"

# S defines the directory containing the source code BitBake uses for the build
S = "${WORKDIR}"

# Inherit systemd and enable it in order to use it
inherit systemd

# These lines are used to enable the service automatically so it can start on boot of the target
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "run-platform.service"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES','systemd', d)}"

PACKAGECONFIG[systemd] = "-DWITH_SYSTEMD=ON,-DWITH_SYSTEMD=OFF,systemd"

# Create the directory /etc/systemd/system if not already done and install the script
# When enabling a service on boot the command must be do_install:append()
do_install:append() {
  install -d ${D}${systemd_unitdir}/system
  # 0755 gives the file the chmod permission 755
  install -m 0755 ${WORKDIR}/run-platform.service ${D}${systemd_unitdir}/system/run-platform.service
}

# Lists the files and directories that are placed in the package PN
# PN refers to a recipe name in the context of a file used by the OpenEmbeded build system
FILES:${PN} = "${systemd_unitdir}/system/run-platform.service"
