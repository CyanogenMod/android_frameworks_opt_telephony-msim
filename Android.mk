
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
# zhaoyunting add for nv write and read 20141218
LOCAL_JAVA_LIBRARIES := telephony-common framework qcnvitems
LOCAL_AIDL_INCLUDES := $(LOCAL_PATH)/src

LOCAL_SRC_FILES += $(call all-java-files-under, src/)

LOCAL_MODULE_TAGS := optional
LOCAL_MODULE := telephony-qmi

include $(BUILD_JAVA_LIBRARY)

# Include subdirectory makefiles
# ============================================================
include $(call all-makefiles-under,$(LOCAL_PATH))

