require ruby.inc

SRC_URI[md5sum] = "326e99ddc75381c7b50c85f7089f3260"
SRC_URI[sha256sum] = "5ffc0f317e429e6b29d4a98ac521c3ce65481bfd22a8cf845fa02a7b113d9b44"

# it's unknown to configure script, but then passed to extconf.rb
# maybe it's not really needed as we're hardcoding the result with
# 0001-socket-extconf-hardcode-wide-getaddr-info-test-outco.patch
UNKNOWN_CONFIGURE_WHITELIST += "--enable-wide-getaddrinfo"

PACKAGECONFIG ??= ""
PACKAGECONFIG += "${@bb.utils.contains('DISTRO_FEATURES', 'ipv6', 'ipv6', '', d)}"

PACKAGECONFIG[valgrind] = "--with-valgrind=yes, --with-valgrind=no, valgrind"
PACKAGECONFIG[gpm] = "--with-gmp=yes, --with-gmp=no, gmp"
PACKAGECONFIG[ipv6] = ",--enable-wide-getaddrinfo,"

EXTRA_OECONF = "\
    --disable-versioned-paths \
    --disable-rpath \
    --disable-dtrace \
    --enable-shared \
    --enable-load-relative \
"

EXTRA_OEMAKE = " \
    LIBRUBYARG='-lruby-static' \
"

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}

do_install_append () {
if [ "${PN}" != "ruby-native" ]; then
    sed -i "s/sysroot=[0-9a-z\/\-]*/sysroot=\//g" ${D}/usr/lib/ruby/*/*/rbconfig.rb
fi
}

FILES_${PN} += "${datadir}/rubygems \
                ${datadir}/ri"

FILES_${PN}-dbg += "${libdir}/ruby/*/.debug \
                    ${libdir}/ruby/*/*/.debug \
                    ${libdir}/ruby/*/*/*/.debug \
                    ${libdir}/ruby/*/*/*/*/.debug"

BBCLASSEXTEND = "native"
