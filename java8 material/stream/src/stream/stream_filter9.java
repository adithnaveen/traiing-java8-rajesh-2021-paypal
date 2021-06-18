package stream;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream_filter9 {
	public static void main(String[] args) {
		Employee.persons().stream().filter(Employee::isFemale)
				.map(Employee::getName).forEach(System.out::println);

		// 2
		Employee.persons().stream().filter(Employee::isMale)
				.filter(p -> p.getIncome() > 5000.0).map(Employee::getName)
				.forEach(System.out::println);
		// 3
		Employee.persons().stream()
				.filter(p -> p.isMale() && p.getIncome() > 5000.0)
				.map(Employee::getName).forEach(System.out::println);

		// map
		Employee.persons().stream().map(Employee::getName)
				.forEach(System.out::println);

		// convert string into character using flatemap
		Stream.of("XML", "Java", "CSS").map(name -> name.chars())
				.flatMap(intStream -> intStream.mapToObj(n -> (char) n))
				.forEach(System.out::println);

		// reduce
		double sum = Employee.persons().stream().map(Employee::getIncome)
				.reduce(0.0, Double::sum);
		System.out.println(sum);

		// aggregation sum
		double totalIncome = Employee.persons().stream()
				.mapToDouble(Employee::getIncome).sum();
		System.out.println("Total Income:  " + totalIncome);

		// minimum and maximum
		OptionalDouble income = Employee.persons().stream()
				.mapToDouble(Employee::getIncome).max();

		if (income.isPresent()) {
			System.out.println("Highest income:   " + income.getAsDouble());
		} else {
			System.out.println("Could not  get   the   highest income.");
		}

		// count means number of element in stream
		long personCount = Employee.persons().stream().count();
		System.out.println("Person count: " + personCount);

		// group data into stream use collect() method
		// List<String> names=(List<String>)
		// Employee.persons().stream().map(Employee::getName).collect(ArrayList::new,
		// ArrayList::add, ArrayList::addAll);
		List<String> names = Employee.persons().stream().map(Employee::getName)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(names);

		// collector interface*************************

		// 1 toList

		List<String> names1 = Employee.persons().stream()
				.map(Employee::getName).collect(Collectors.toList());
		System.out.println(names1);
//************************************************************************
		// 2 tocollection
		java.util.SortedSet<String> uniqueSortedNames = Employee.persons()
				.stream().map(Employee::getName)
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(uniqueSortedNames);
		//System.out.println(uniqueSortedNames);

		// 3 DoubleSummaryStatistics
		// 4 LongSummaryStatistics
		// 5 IntSummaryStatistics
		DoubleSummaryStatistics incomeStats = Employee.persons().stream()
				.collect(Collectors.summarizingDouble(Employee::getIncome));
		System.out.println("summarizing "+incomeStats);

		// 6 map to display
		java.util.Map<Long, String> idToNameMap = Employee.persons().stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println("map 1   "+idToNameMap);

		// male separate, female separate
		java.util.Map<Employee.Gender, String> genderToNamesMap = Employee
				.persons()
				.stream()
				.collect(
						Collectors.toMap(Employee::getGender,
								Employee::getName,
								(oldValue, newValue) -> String.join(", ",
										oldValue, newValue)));
		System.out.println(genderToNamesMap);
		// no of male no of female
		List<Employee> emp=null;
		java.util.Map<Employee.Gender, Long> countByGender = Employee
				.persons()
				.stream()
				.collect(
						Collectors.toMap(Employee::getGender, p -> 1L, (
								oldCount, newCount) -> newCount + oldCount));

		System.out.println("count by gender -->  "+countByGender);
		// collector joining
		List<Employee> persons = Employee.persons();
		String names11 = persons.stream().map(Employee::getName)
				.collect(Collectors.joining());

		String delimitedNames = persons.stream().map(Employee::getName)
				.collect(Collectors.joining(", "));

		String prefixedNames = persons.stream().map(Employee::getName)
				.collect(Collectors.joining(", ", "Hello ", ".  Goodbye."));

		System.out.println("Joined names:  " + names11);
		System.out.println("Joined,  delimited names:  " + delimitedNames);
		System.out.println(prefixedNames);

		// grouping
		java.util.Map<Employee.Gender, Long> countByGender1 = Employee
				.persons()
				.stream()
				.collect(
						Collectors.groupingBy(Employee::getGender,
								Collectors.counting()));
		System.out.println(countByGender1);

		// partitioning
		java.util.Map<Boolean, String> partionedByMaleGender = Employee
				.persons()
				.stream()
				.collect(
						Collectors.partitioningBy(Employee::isMale, Collectors
								.mapping(Employee::getName,
										Collectors.joining(", "))));
		System.out.println(partionedByMaleGender);
	}
}

class Employee {
	public static enum Gender {
		MALE, FEMALE
	}
	private long id;
	private String name;
	private Gender gender;
	private LocalDate dob;
	private double income;

	public Employee(long id, String name, Gender gender, LocalDate dob,
			double income) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.income = income;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public boolean isMale() {
		return this.gender == Gender.MALE;
	}

	public boolean isFemale() {
		return this.gender == Gender.FEMALE;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public static List<Employee> persons() {
		Employee p1 = new Employee(1, "Jake", Gender.MALE, LocalDate.of(1971,
				Month.JANUARY, 1), 2343.0);
		Employee p2 = new Employee(2, "Jack", Gender.MALE, LocalDate.of(1972,
				Month.JULY, 21), 7100.0);
		Employee p3 = new Employee(3, "Jane", Gender.FEMALE, LocalDate.of(1973,
				Month.MAY, 29), 5455.0);
		Employee p4 = new Employee(4, "Jode", Gender.MALE, LocalDate.of(1974,
				Month.OCTOBER, 16), 1800.0);
		Employee p5 = new Employee(5, "Jeny", Gender.FEMALE, LocalDate.of(1975,
				Month.DECEMBER, 13), 1234.0);
		Employee p6 = new Employee(6, "Jason", Gender.MALE, LocalDate.of(1976,
				Month.JUNE, 9), 3211.0);

		List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

		return persons;
	}

	@Override
	public String toString() {
		String str = String.format("(%s, %s,  %s,  %s,  %.2f)\n", id, name,
				gender, dob, income);
		return str;
	}
}