package com.example.common.utils

class ApiResponseUtil {
    companion object {
        val successCode = "0"
        //val responseMsg = ""

        /**
         * OK
         */
        fun SuccessResponse(msg:String?,data:Any?) : HashMap<String, Any?> {
            val r = HashMap<String, Any?>()
            r.put("result_code", "${successCode}")
            r.put("result_msg","${msg}")
            r.put("result_data",data)
            return r
        }
        
        fun FailureResponse(msg:String?,code:String?) : HashMap<String, Any?> {
            val r = HashMap<String, Any?>()
            r.put("result_code","${code}")
            r.put("result_msg","${msg}")
            return r
        }
   }
}