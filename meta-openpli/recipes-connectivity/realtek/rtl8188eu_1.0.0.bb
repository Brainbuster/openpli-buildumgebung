DESCRIPTION = "Driver for Realtek USB wireless devices"
HOMEPAGE = "http://www.realtek.com/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

RDEPENDS_${PN} = " \
	firmware-rtl8188eu \
	"

inherit module machine_kernel_pr gitpkgv

SRC_URI = "git://github.com/lwfinger/rtl8188eu.git"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

MACHINE_KERNEL_PR_append = ".0"

EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/8188eu.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless

}

SRC_URI[md5sum] = "addb3bc7b06ecdd86cc4de15e14fc67d"
SRC_URI[sha256sum] = "a13b2f21b77b06bff55be06cb3d9721fe26b2c4fe484889cb663b545077c74de"
