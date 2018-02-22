/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class ibm_Pipes */

#ifndef _Included_ibm_Pipes
#define _Included_ibm_Pipes
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     ibm_Pipes
 * Method:    CreateNamedPipe
 * Signature: (Ljava/lang/String;IIIIIII)I
 */
JNIEXPORT jint JNICALL Java_ibm_Pipes_CreateNamedPipe
  (JNIEnv *, jclass, jstring, jint, jint, jint, jint, jint, jint, jint);

/*
 * Class:     ibm_Pipes
 * Method:    ConnectNamedPipe
 * Signature: (II)Z
 */
JNIEXPORT jboolean JNICALL Java_ibm_Pipes_ConnectNamedPipe
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     ibm_Pipes
 * Method:    GetLastError
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_ibm_Pipes_GetLastError
  (JNIEnv *, jclass);

/*
 * Class:     ibm_Pipes
 * Method:    CloseHandle
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_ibm_Pipes_CloseHandle
  (JNIEnv *, jclass, jint);

/*
 * Class:     ibm_Pipes
 * Method:    ReadFile
 * Signature: (II)[B
 */
JNIEXPORT jbyteArray JNICALL Java_ibm_Pipes_ReadFile
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     ibm_Pipes
 * Method:    WriteFile
 * Signature: (I[BI)I
 */
JNIEXPORT jint JNICALL Java_ibm_Pipes_WriteFile
  (JNIEnv *, jclass, jint, jbyteArray, jint);

/*
 * Class:     ibm_Pipes
 * Method:    FlushFileBuffers
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_ibm_Pipes_FlushFileBuffers
  (JNIEnv *, jclass, jint);

/*
 * Class:     ibm_Pipes
 * Method:    DisconnectNamedPipe
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_ibm_Pipes_DisconnectNamedPipe
  (JNIEnv *, jclass, jint);

/*
 * Class:     ibm_Pipes
 * Method:    CreateFile
 * Signature: (Ljava/lang/String;IIIIII)I
 */
JNIEXPORT jint JNICALL Java_ibm_Pipes_CreateFile
  (JNIEnv *, jclass, jstring, jint, jint, jint, jint, jint, jint);

/*
 * Class:     ibm_Pipes
 * Method:    WaitNamedPipe
 * Signature: (Ljava/lang/String;I)Z
 */
JNIEXPORT jboolean JNICALL Java_ibm_Pipes_WaitNamedPipe
  (JNIEnv *, jclass, jstring, jint);

/*
 * Class:     ibm_Pipes
 * Method:    FormatMessage
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ibm_Pipes_FormatMessage
  (JNIEnv *, jclass, jint);

/*
 * Class:     ibm_Pipes
 * Method:    Print
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_ibm_Pipes_Print
  (JNIEnv *, jclass, jstring);

#ifdef __cplusplus
}
#endif
#endif
