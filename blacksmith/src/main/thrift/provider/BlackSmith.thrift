namespace java com.sauzny.finagle.thrift.blacksmith

include "../common/params.thrift"
include "../common/result.thrift"

struct QueryParams{
  	1:params.CommonParams commonParams
}

struct QueryResult{
	1:result.CommonResult commonResult
}

service BlackSmithServer{

    QueryResult query(1:QueryParams QueryParams);

	result.CommonResult ping();
}
