LOCAL_PATH := $(call my-dir)
#测试
include $(CLEAR_VARS)
LOCAL_MODULE    := hello-jni
LOCAL_SRC_FILES := com_example_asus_myndktest2_NDKUtils.c
LOCAL_LDLIBS    := -lm -llog
include $(BUILD_SHARED_LIBRARY)

#增量更新
include $(CLEAR_VARS)
LOCAL_MODULE    := bspatch
LOCAL_SRC_FILES := com_example_asus_myndktest2_PatchUtils.c
LOCAL_LDLIBS    := -lm -llog
include $(BUILD_SHARED_LIBRARY)
