# 저장소 설명
GC를 발생시킬 수 있는 프로젝트를 실행시키고 내용을 분석해본다

# 분석 방법
도구
- jstat, visualVM: GC 처리 정보를 모니터링

옵션
- 샘플: `java -Xms5m -Xmx10m -XX:+UseG1GC -XX:+HeapDumpOnOutOfMemoryError -verbosegc -jar build/libs/gc-maker-1.0-SNAPSHOT.jar`
- Xms, Xmx: 메모리 용량을 조절해서 GC 발생 빈도와 OutOfMemory를 발생시킬 수 있도록 야기한다
- verbosegc: gc가 발생할 때 발생 내역을 console 화면에 출력해준다
- -XX:+HeapDumpOnOutOfMemoryError: OutOfMemory가 발생했을 때 힙덤프를 생성해준다

