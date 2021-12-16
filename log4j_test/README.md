# 배경
Log4J2에서 Lookup 관련 보안이슈를 테스트해보기 위한 저장소

# 테스트 방법
1. org.apache.logging.log4j 버전을 2.14.1로 설정해서 lookup이 발생하는지 확인 -> 발생함
2. org.apache.logging.log4j 버전을 2.15.0으로 올려서 lookup이 발생하는지 확인 -> 발생하지 않음
3. org.apache.logging.log4j 버전을 2.14.1로 설정하고 VMOptions에 `-Dlog4j2.formatMsgNoLookups=true`를 설정하고 lookup이 발생하는지 확인 -> 발생하지 않음