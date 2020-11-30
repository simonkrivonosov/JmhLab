package JsonBenchmark;

import Dto.ProtoDto;
import com.googlecode.protobuf.format.XmlFormat;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.Arrays;

public class ProtobufSerealizationBench {
    static ProtoDto.InnerDto innerDto = ProtoDto.InnerDto.newBuilder()
            .setName("InnerDto")
            .setX(Math.PI)
            .build();

    static ProtoDto.DtoExample dtoExample = ProtoDto.DtoExample.newBuilder()
            .setId(0)
            .setName("dtoExample")
            .addAllNumbers(Arrays.asList(1,2,3))
            .setInnerDto(innerDto)
            .build();

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    public String testSerialization() throws IOException {
        return XmlFormat.printToString(innerDto);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ProtobufSerealizationBench.class.getSimpleName())
                .threads(4)
                .warmupIterations(3)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
