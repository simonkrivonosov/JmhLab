package JsonBenchmark;

import Dto.DtoExample;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.*;

public class SerializationJsonBench {
    private static DtoExample dtoExample = new DtoExample();
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }


    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    public String testSerialization() throws JsonProcessingException {
        return objectMapper.writeValueAsString(dtoExample);
    }

    //просто чтобы заодно проверить сериализацию
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void testSingleShort() throws IOException {
        String res = objectMapper.writeValueAsString(dtoExample);
        OutputStream os = new FileOutputStream(new File("/Users/simon/simon_github/JmhLab/src/main/resources/result.txt"));
        os.write(res.getBytes(), 0, res.length());
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SerializationJsonBench.class.getSimpleName())
                .threads(4)
                .warmupIterations(3)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
