## RealTime  - JMeter Performance Reports
* Before run this line
	* Delete the file previous File **"RealTime_Performance_Test.csv"**
	* Delete the previous folder **"JMeter-Reports-RealTime"**
```
	jmeter -n -t D:/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Tests_RestController.jmx -l D:/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Performance_Test.csv -e -o D:/Projects/RealTime_RestController/Jmeter_Performance/JMeter-Reports-RealTime/
	or
	RealTime_Pattern_Tests_RestController
	jmeter -n -t D:/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Pattern_Tests_RestController.jmx -l D:/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Pattern_Performance_Test.csv -e -o D:/Projects/RealTime_RestController/Jmeter_Performance/JMeter-Pattern-Reports-RealTime/
	or for "C:/"
	jmeter -n -t C:/Martini/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Pattern_Tests_RestController.jmx -l C:/Martini/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Pattern_Performance_Test.csv -e -o C:/Martini/Projects/RealTime_RestController/Jmeter_Performance/JMeter-Pattern-Reports-RealTime/

```


### Report Summary
> Open the **index.html** whitin the Folder: 
```
		{Your Main Folder}/RealTime_RestController/Jmeter_Performance/JMeter-Reports-RealTime/index.html
```

### Sequential Report Summary
```
	jmeter -n -t D:/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Tests_RestController.jmx -l D:/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Performance_Test-1.csv -e -o D:/Projects/RealTime_RestController/Jmeter_Performance/HTMLReports-1/
	jmeter -n -t D:/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Tests_RestController.jmx -l D:/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Performance_Test-2.csv -e -o D:/Projects/RealTime_RestController/Jmeter_Performance/HTMLReports-2/
	jmeter -n -t D:/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Tests_RestController.jmx -l D:/Projects/RealTime_RestController/Jmeter_Performance/RealTime_Performance_Test-3.csv -e -o D:/Projects/RealTime_RestController/Jmeter_Performance/HTMLReports-3/
```

### To run these agregations you will need to install JMeter Plugins
* **CMDRunner.jar** and  **JMeterPluginsCMD.jar**
	* Aggregate Report
```
	java -jar CMDRunner.jar  --tool Reporter --generate-csv Aggregate-RealTime-50-Threads.csv --input-jtl out/test-results.csv --plugin-type AggregateReport
	java -jar JMeterPluginsCMD.jar --generate-csv Aggregate-RealTime-50-Threads.csv --input-jtl testResults.jtl --plugin-type AggregateReport
```