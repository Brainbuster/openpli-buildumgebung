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

SRC_URI[md5sum] = "bdb37d8c4818c6d77b476a1c9e3b4783"
SRC_URI[sha256sum] = "30f03aeb395b7e8415a3c8cc2797cc91010119bc620f9fff95f58ceb6bc7df4b"
