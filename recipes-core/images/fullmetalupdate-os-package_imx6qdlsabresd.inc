# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
PREINSTALLED_CONTAINERS_LIST_append = "container-hello-world"

IMAGE_INSTALL_append = " \
    kernel-module-imx-gpu-viv \
"

IMAGE_ROOTFS_EXTRA_SPACE = "314572"
