Protobuf results:

1)Serealizaiton

| Benchmark  | Mode | Cnt | Score | Error | Units |
|:----:|:---------:|:----:|:----:|:---------:|:----:|
| JsonBenchmark.ProtobufSerealizationBench.testSerialization | thrpt | 5 | 5523210,980 | ± 654029,439 | ops/s |
| JsonBenchmark.ProtobufSerealizationBench.testSerialization  | avgt | 5 | ≈ 10⁻⁶ | | s/op |

2)Deserealization

| Benchmark  | Mode | Cnt | Score | Error | Units |
|:----:|:---------:|:----:|:----:|:---------:|:----:|
| JsonBenchmark.ProtobufDeserealizationBench.testDeserialization  | thrpt | 5 | 23336687,876 | ± 1230146,680 | ops/s |
| JsonBenchmark.ProtobufDeserealizationBench.testDeserialization  | avgt | 5 | ≈ 10⁻⁷ | | s/op |

Json results:

1)Serialization

| Benchmark  | Mode | Cnt | Score | Error | Units |
|:----:|:---------:|:----:|:----:|:---------:|:----:|
| JsonBenchmark.SerializationJsonBench.testSerialization| thrpt | 5 | 4755269,142 | ± 86729,538 | ops/s |
| JsonBenchmark.SerializationJsonBench.testSerialization   | avgt | 5 | ≈ 10⁻⁶ | | s/op |

2)Deserealization

| Benchmark  | Mode | Cnt | Score | Error | Units |
|:----:|:---------:|:----:|:----:|:---------:|:----:|
| JsonBenchmark.DeserializationJsonBench.testDeserialization | thrpt | 5 | 3968336,928 | ± 285033,554 | ops/s |
| JsonBenchmark.DeserializationJsonBench.testDeserialization | avgt | 5 | ≈ 10⁻⁶ | | s/op |

Как и ожидалось, Protobuf отрабатывает на порядок быстрее при десереализации, что сходится с заявлениямии google, и на 20%-40% быстрее раза быстрее при сериализации. Хотя справедливости ради стоит отменить, что лабораторные условия не совсем соблюдены, но о какой то тенденции все так можно говорить.