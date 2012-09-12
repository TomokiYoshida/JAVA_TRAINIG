package ch16.ex16_04;

@StringAnnotation("class")
public class Sample {

		@StringAnnotation("constructor")
		public Sample() {
		}

		@StringAnnotation("field")
		public int n;

		@StringAnnotation("method")
		public void function(
			@StringAnnotation("param1")
			int param,
			@StringAnnotation("param2")
			int p2
		) {
			@StringAnnotation("local variable")
			int a = 1;
		}
	}
