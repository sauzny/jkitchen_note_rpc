namespace java com.sauzny.thrift.bellbang

include "../common/params.thrift"
include "../common/result.thrift"

struct QueryParams{
  	1:params.CommonParams commonParams
}

struct QueryResult{
	1:result.CommonResult commonResult
}

service BellBangServer{

    QueryResult query(1:QueryParams QueryParams);

	result.CommonResult ping();
}
