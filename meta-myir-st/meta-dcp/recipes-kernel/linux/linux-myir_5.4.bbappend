FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"
KERNEL_CONFIG_FRAGMENTS_append += "${WORKDIR}/fragments/5.4.31-r0/fragment-01-qmi.config"
SRC_URI += " file://5.4.31-r0/fragment-01-qmi.config;subdir=fragments "
