package com.codeaurora.telephony.msim;

import android.content.Context;
import com.qualcomm.qcnvitems.QcNvItems;

/* zhaoyunting create for nv write and read 20141218 */
/*
 * use this class we must use initQcNvItemSyncChannel function
 * because we must init qcril nv and qcril hook sync channel when app is started
 *
 * for example 
 * TelephonyUtils.getDefault(contxt).initQcNvItemSyncChannel();
 * TelephonyUtils.getDefault(contxt).getPN;
 *
*/
public class TelephonyUtils {
    private static Context mContext;
    private static TelephonyUtils sInstance;
    private static QcNvItems mQcNI = null;

    private static final String PN_NV_ITEM_ID = "2497";
    /* mengtengfei modify for SN_NV_ITEM_ID 20150212 start */
    private static final String SN_NV_ITEM_ID = "2497";
    /* mengtengfei modify for SN_NV_ITEM_ID 20150212 end */
    private static final String STATION_STATE_NV_ITEM_ID = "2499";
    private static final String BASEBAND_NV_ITEM_ID = "2808";
    /* mengtengfei modify for DiagLock 20150212 start */
    private static final String NV_DIAG_LOCK_ID="2500";
    /* mengtengfei modify for DiagLock 20150212 end */

    private TelephonyUtils(Context context) {
        mContext = context;
    }

    public static TelephonyUtils getDefault(Context context) {
        if (sInstance == null) {
            sInstance = new TelephonyUtils(context);
        }
        return sInstance;
    }

    public void initQcNvItemSyncChannel() {
        if(null == mQcNI) {
            mQcNI = new QcNvItems(mContext);
        }
    }

    private boolean setNVItem(String nvItemId, String value) {
        try {
            initQcNvItemSyncChannel();
            return mQcNI.setNVItem(nvItemId, value);
        } catch (Exception ex) {
            return false;
        }
    }

    private String getNVItem(String nvItemId) {
        try {
            initQcNvItemSyncChannel();
            return mQcNI.getNVItem(nvItemId);
        } catch (Exception ex) {
            return null;
        }
    }

   public String getSN() {
       return getNVItem(SN_NV_ITEM_ID);
   }

   public String getPN() {
       return getNVItem(PN_NV_ITEM_ID);
   }

   public String getBasebandVersion() {
       return getNVItem(BASEBAND_NV_ITEM_ID);
   }

   public String getStationsState() {
       return getNVItem(STATION_STATE_NV_ITEM_ID);
   }

   public boolean setStationsState(String value) {
       return setNVItem(STATION_STATE_NV_ITEM_ID, value);
   }

   public String getDiagLockSwitch(){
       return getNVItem(NV_DIAG_LOCK_ID);
   }
   public boolean setDiagLockSwitch(String value){
       return setNVItem(NV_DIAG_LOCK_ID, value);
   }
}
