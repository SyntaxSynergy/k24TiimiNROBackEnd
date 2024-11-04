package s24.varasto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import s24.varasto.web.VarastoController;

@SpringBootTest
class VarastoApplicationTests {

	@Autowired
	private VarastoController controller;

	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}
