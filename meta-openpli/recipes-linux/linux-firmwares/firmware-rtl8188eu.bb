LICENSE = "CLOSED"

DESCRIPTION = "Firmware for RTL8188EU"

SRC_URI = "https://github.com/lwfinger/rtl8188eu/archive/master.zip"

S = "${WORKDIR}/rtl8188eu-master"

do_install() {
	install -d ${D}${base_libdir}/firmware/rtlwifi
	install -m 0644 rtl8188eufw.bin ${D}/${base_libdir}/firmware/rtlwifi/
}

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"

SRC_URI[md5sum] = "dcb6af10103a3d90bb5ce9f254843ba6"
SRC_URI[sha256sum] = "d93c2b265c40fefd601ce7c686891bb96aae7475fd50955274734c60559fc05d"
