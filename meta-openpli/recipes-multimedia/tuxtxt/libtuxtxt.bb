SUMMARY = "tuxbox libtuxtxt"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"
DEPENDS = "libpng freetype"

inherit gitpkgv

SRCREV = "b6c8d5a3b182498d1195fd70860fc2a0c70fa9d2"
SRC_URI = "git://git.code.sf.net/p/openpli/tuxtxt"

S = "${WORKDIR}/git/libtuxtxt"

PV = "2.0+git${SRCPV}"
PKGV = "2.0+git${GITPKGV}"
PR = "r0"

EXTRA_OECONF = "--with-boxtype=generic"

inherit autotools pkgconfig

FILES_${PN} = "/usr/lib/libtuxtxt.so.*"
FILES_${PN}-dev = "/usr/include/ /usr/lib/libtuxtxt.la /usr/lib/pkgconfig/tuxbox-tuxtxt.pc"
