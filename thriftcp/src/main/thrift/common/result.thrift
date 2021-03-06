namespace java com.sauzny.thrift.common

enum ResultStatus{
	failure
	success
}

struct FailDesc {
	1:string name
	2:string failCode
	3:string desc
}

struct CommonResult {
 	1:ResultStatus resultStatus = ResultStatus.failure,
 	2:optional list<FailDesc> failDescList,
	3:optional map<string, string> resultMap,
	4:optional i64 timing, 	   		//处理时间
	5:optional string traceId,		//追踪id
}
