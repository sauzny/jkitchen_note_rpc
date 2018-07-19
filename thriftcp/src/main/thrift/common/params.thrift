namespace java com.sauzny.thrift.common

struct CommonParams{
 	1:string version
 	2:optional string aliasName
	3:optional map<string, string> paramsMap
	4:optional string traceId		//追踪id
}
