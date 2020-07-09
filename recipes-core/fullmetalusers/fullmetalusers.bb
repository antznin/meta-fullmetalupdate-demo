# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
SUMMARY = "Configuration for users on the target"
DESCRIPTION = "This recipe adds a fmu user with uid/gid 1000, and adds the fmu group"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

S = "${WORKDIR}"

inherit useradd

USERADD_PACKAGES = "${PN}"

# Adding group fmu
GROUPADD_PARAM_${PN} = "-g 1000 fmu"

# Adding user fmu, which belongs to group fmu
# Use `openssl passwd <password>` to get the hash result of a password
# Current password is 'fmu'
USERADD_PARAM_${PN} = "-u 1000 -d /home/fmu -r -s /bin/sh -g fmu -p t22MRHUq3gTPI fmu"

do_install_append () {
    install -d -m 755 ${D}/home/fmu
    chown -R fmu ${D}/home/fmu
    chgrp -R fmu ${D}/home/fmu
}

FILES_${PN} = "/home/fmu"
