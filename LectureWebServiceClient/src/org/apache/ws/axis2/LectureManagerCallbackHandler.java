/**
 * LectureManagerCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.5  Built on : May 06, 2017 (03:45:26 BST)
 */
package org.apache.ws.axis2;


/**
 *  LectureManagerCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class LectureManagerCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public LectureManagerCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public LectureManagerCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getAllLectures method
     * override this method for handling normal response from getAllLectures operation
     */
    public void receiveResultgetAllLectures(
        org.apache.ws.axis2.LectureManagerStub.GetAllLecturesResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getAllLectures operation
     */
    public void receiveErrorgetAllLectures(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for refreshLecture method
     * override this method for handling normal response from refreshLecture operation
     */
    public void receiveResultrefreshLecture() {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from refreshLecture operation
     */
    public void receiveErrorrefreshLecture(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getFreeTime method
     * override this method for handling normal response from getFreeTime operation
     */
    public void receiveResultgetFreeTime(
        org.apache.ws.axis2.LectureManagerStub.GetFreeTimeResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getFreeTime operation
     */
    public void receiveErrorgetFreeTime(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for quit method
     * override this method for handling normal response from quit operation
     */
    public void receiveResultquit() {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from quit operation
     */
    public void receiveErrorquit(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getLecture method
     * override this method for handling normal response from getLecture operation
     */
    public void receiveResultgetLecture(
        org.apache.ws.axis2.LectureManagerStub.GetLectureResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getLecture operation
     */
    public void receiveErrorgetLecture(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for replace method
     * override this method for handling normal response from replace operation
     */
    public void receiveResultreplace() {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from replace operation
     */
    public void receiveErrorreplace(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for addLecture method
     * override this method for handling normal response from addLecture operation
     */
    public void receiveResultaddLecture(
        org.apache.ws.axis2.LectureManagerStub.AddLectureResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from addLecture operation
     */
    public void receiveErroraddLecture(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for deleteLecture method
     * override this method for handling normal response from deleteLecture operation
     */
    public void receiveResultdeleteLecture(
        org.apache.ws.axis2.LectureManagerStub.DeleteLectureResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from deleteLecture operation
     */
    public void receiveErrordeleteLecture(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for updateLecture method
     * override this method for handling normal response from updateLecture operation
     */
    public void receiveResultupdateLecture(
        org.apache.ws.axis2.LectureManagerStub.UpdateLectureResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from updateLecture operation
     */
    public void receiveErrorupdateLecture(java.lang.Exception e) {
    }
}
