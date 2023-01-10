SUMMARY = "DJB daemontools"
HOMEPAGE = "http://cr.yp.to/daemontools.html"
DESCRIPTION = "supervise monitors a service. It starts the service and restarts the \
service if it dies. The companion svc program stops, pauses, or restarts \
the service on sysadmin request. The svstat program prints a one-line \
status report. \
multilog saves error messages to one or more logs.  It optionally timestamps \
each line and, for each log, includes or excludes lines matching specified \
patterns.  It automatically rotates logs to limit the amount of disk space \
used.  If the disk fills up, it pauses and tries again, without losing any \
data."

SECTION = "System/Servers"

LIC_FILES_CHKSUM = "file://src/prot.c;beginline=1;endline=1;md5=96964cadf07e8f8c1e2ffb3b507dd647"
LICENSE = "PD"

SRC_URI = "http://cr.yp.to/daemontools/${BPN}-${PV}.tar.gz \
    file://0001-error.h-include-errno.h-instead-of-extern-int.diff \
    file://0002-supervise.c-.-supervise-may-be-a-symlink-if-it-s-da.diff \
    file://cross-compile.patch \
    file://0001-daemontools-Fix-QA-Issue.patch \
"

SRC_URI[md5sum] = "1871af2453d6e464034968a0fbcb2bfc"
SRC_URI[sha256sum] = "a55535012b2be7a52dcd9eccabb9a198b13be50d0384143bd3b32b8710df4c1f"

S = "${WORKDIR}/admin/${BP}"

do_compile() {
    ./package/compile
}

do_install() {
    install -d ${D}/${bindir}
}

do_install_append_class-target() {
    install -m755 ${S}/command/* ${D}/${bindir}
}
