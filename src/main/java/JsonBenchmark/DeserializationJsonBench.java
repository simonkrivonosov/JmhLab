package JsonBenchmark;

import Dto.DtoExample;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;

@State(Scope.Benchmark)
public class DeserializationJsonBench {
    private static DtoExample dtoExample = new DtoExample();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private String json;

    @Setup
    public void setUp() {
        try {
            json = objectMapper.writeValueAsString(dtoExample);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    public DtoExample testDeserialization() throws IOException {
        return objectMapper.readValue(json, DtoExample.class);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DeserializationJsonBench.class.getSimpleName())
                .threads(4)
                .warmupIterations(3)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
